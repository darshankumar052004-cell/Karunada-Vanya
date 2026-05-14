package com.karunadavanya.app.data.repository;

import com.karunadavanya.app.data.local.dao.AlertDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AlertRepository_Factory implements Factory<AlertRepository> {
  private final Provider<AlertDao> alertDaoProvider;

  public AlertRepository_Factory(Provider<AlertDao> alertDaoProvider) {
    this.alertDaoProvider = alertDaoProvider;
  }

  @Override
  public AlertRepository get() {
    return newInstance(alertDaoProvider.get());
  }

  public static AlertRepository_Factory create(Provider<AlertDao> alertDaoProvider) {
    return new AlertRepository_Factory(alertDaoProvider);
  }

  public static AlertRepository newInstance(AlertDao alertDao) {
    return new AlertRepository(alertDao);
  }
}
