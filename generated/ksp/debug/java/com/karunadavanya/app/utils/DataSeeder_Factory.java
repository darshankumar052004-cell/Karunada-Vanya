package com.karunadavanya.app.utils;

import android.content.Context;
import com.karunadavanya.app.data.repository.WildlifeRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DataSeeder_Factory implements Factory<DataSeeder> {
  private final Provider<Context> contextProvider;

  private final Provider<WildlifeRepository> wildlifeRepositoryProvider;

  public DataSeeder_Factory(Provider<Context> contextProvider,
      Provider<WildlifeRepository> wildlifeRepositoryProvider) {
    this.contextProvider = contextProvider;
    this.wildlifeRepositoryProvider = wildlifeRepositoryProvider;
  }

  @Override
  public DataSeeder get() {
    return newInstance(contextProvider.get(), wildlifeRepositoryProvider.get());
  }

  public static DataSeeder_Factory create(Provider<Context> contextProvider,
      Provider<WildlifeRepository> wildlifeRepositoryProvider) {
    return new DataSeeder_Factory(contextProvider, wildlifeRepositoryProvider);
  }

  public static DataSeeder newInstance(Context context, WildlifeRepository wildlifeRepository) {
    return new DataSeeder(context, wildlifeRepository);
  }
}
