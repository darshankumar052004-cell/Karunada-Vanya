package com.karunadavanya.app;

import com.karunadavanya.app.utils.DataSeeder;
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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<DataSeeder> dataSeederProvider;

  public MainActivity_MembersInjector(Provider<DataSeeder> dataSeederProvider) {
    this.dataSeederProvider = dataSeederProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<DataSeeder> dataSeederProvider) {
    return new MainActivity_MembersInjector(dataSeederProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectDataSeeder(instance, dataSeederProvider.get());
  }

  @InjectedFieldSignature("com.karunadavanya.app.MainActivity.dataSeeder")
  public static void injectDataSeeder(MainActivity instance, DataSeeder dataSeeder) {
    instance.dataSeeder = dataSeeder;
  }
}
