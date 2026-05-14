package com.karunadavanya.app.ui.alerts;

import com.karunadavanya.app.data.repository.AlertRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AlertViewModel_Factory implements Factory<AlertViewModel> {
  private final Provider<AlertRepository> alertRepositoryProvider;

  public AlertViewModel_Factory(Provider<AlertRepository> alertRepositoryProvider) {
    this.alertRepositoryProvider = alertRepositoryProvider;
  }

  @Override
  public AlertViewModel get() {
    return newInstance(alertRepositoryProvider.get());
  }

  public static AlertViewModel_Factory create(Provider<AlertRepository> alertRepositoryProvider) {
    return new AlertViewModel_Factory(alertRepositoryProvider);
  }

  public static AlertViewModel newInstance(AlertRepository alertRepository) {
    return new AlertViewModel(alertRepository);
  }
}
