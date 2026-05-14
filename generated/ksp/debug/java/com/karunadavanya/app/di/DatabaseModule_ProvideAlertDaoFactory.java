package com.karunadavanya.app.di;

import com.karunadavanya.app.data.local.AppDatabase;
import com.karunadavanya.app.data.local.dao.AlertDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseModule_ProvideAlertDaoFactory implements Factory<AlertDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideAlertDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public AlertDao get() {
    return provideAlertDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideAlertDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideAlertDaoFactory(databaseProvider);
  }

  public static AlertDao provideAlertDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideAlertDao(database));
  }
}
