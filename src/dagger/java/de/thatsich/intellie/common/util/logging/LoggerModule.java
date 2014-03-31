package de.thatsich.intellie.common.util.logging;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.common.module.IModule;

import javax.inject.Singleton;

/**
 * Module for Logging
 * Requires an actual ID which is used to identify from which logger
 * the message was actual printed
 *
 * @author thatsIch
 * @date 05.03.14.
 */
@Module(
        library = true,
        injects = ILog.class
)
public class LoggerModule implements IModule {
    private final String name;

    public LoggerModule(final String name) {
        this.name = name;
    }

    @Provides
    @Singleton
    public ILog provideLogger() {
        return new Log(this.name);
    }
}
