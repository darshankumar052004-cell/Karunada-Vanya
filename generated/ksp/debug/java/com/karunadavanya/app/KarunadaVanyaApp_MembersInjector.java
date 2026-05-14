package com.karunadavanya.app;

import androidx.hilt.work.HiltWorkerFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class KarunadaVanyaApp_MembersInjector implements MembersInjector<KarunadaVanyaApp> {
  private final Provider<HiltWorkerFactory> workerFactoryProvider;

  public KarunadaVanyaApp_MembersInjector(Provider<HiltWorkerFactory> workerFactoryProvider) {
    this.workerFactoryProvider = workerFactoryProvider;
  }

  public static MembersInjector<KarunadaVanyaApp> create(
      Provider<HiltWorkerFactory> workerFactoryProvider) {
    return new KarunadaVanyaApp_MembersInjector(workerFactoryProvider);
  }

  @Override
  public void injectMembers(KarunadaVanyaApp instance) {
    injectWorkerFactory(instance, workerFactoryProvider.get());
  }

  @InjectedFieldSignature("com.karunadavanya.app.KarunadaVanyaApp.workerFactory")
  public static void injectWorkerFactory(KarunadaVanyaApp instance,
      HiltWorkerFactory workerFactory) {
    instance.workerFactory = workerFactory;
  }
}
