package com.luotao.showcase.web;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.utils.ConfigUtils;
import com.alibaba.dubbo.container.Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainStartupUser {
    public static final String CONTAINER_KEY = "dubbo.container";

    public static final String SHUTDOWN_HOOK_KEY = "dubbo.shutdown.hook";

    private static final Logger logger = LoggerFactory.getLogger(MainStartupUser.class);

    private static final ExtensionLoader<Container> loader = ExtensionLoader
            .getExtensionLoader(Container.class);

    private static volatile boolean running = true;


    public static void main(String[] args) {

        try {
            if (args == null || args.length == 0) {
                String config = ConfigUtils.getProperty(CONTAINER_KEY,
                        loader.getDefaultExtensionName());
                args = Constants.COMMA_SPLIT_PATTERN.split(config);
            }

            final List<Container> containers = new ArrayList<Container>();
            for (String arg : args) {
                containers.add(loader.getExtension(arg));
            }
            logger.info("Use container type(" + Arrays.toString(args) + ") to run dubbo serivce.");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
            applicationContext.start();
            if ("true".equals(System.getProperty(SHUTDOWN_HOOK_KEY))) {
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    public void run() {
                        for (Container container : containers) {
                            try {
                                container.stop();
                                logger.info("Dubbo " + container.getClass().getSimpleName()
                                        + " stopped!");
                            } catch (Exception t) {
                                logger.error(t.getMessage(), t);
                            }
                            synchronized (MainStartupUser.class) {
                                running = false;
                                MainStartupUser.class.notify();
                            }
                        }
                    }
                });
            }

            logger.info("Dubbo base-user-svr service server starting...");
            for (Container container : containers) {
                container.start();
                logger.info("Dubbo " + container.getClass().getSimpleName() + " started!");
            }
            logger.info("Dubbo base-user-svr service server started!");

        } catch (RuntimeException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            System.exit(1);
        }

        synchronized (MainStartupUser.class) {
            while (running) {
                try {
                    MainStartupUser.class.wait();
                } catch (Exception ignore) {
                }
            }
        }
    }
}
