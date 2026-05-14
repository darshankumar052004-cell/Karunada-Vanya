package com.karunadavanya.app.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.karunadavanya.app.data.repository.AlertRepository;
import dagger.internal.DaggerGenerated;
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
public final class AlertExpiryWorker_Factory {
  private final Provider<AlertRepository> alertRepositoryProvider;

  public AlertExpiryWorker_Factory(Provider<AlertRepository> alertRepositoryProvider) {
    this.alertRepositoryProvider = alertRepositoryProvider;
  }

  public AlertExpiryWorker get(Context context, WorkerParameters workerParams) {
    return newInstance(context, workerParams, alertRepositoryProvider.get());
  }

  public static AlertExpiryWorker_Factory create(
      Provider<AlertRepository> alertRepositoryProvider) {
    return new AlertExpiryWorker_Factory(alertRepositoryProvider);
  }

  public static AlertExpiryWorker newInstance(Context context, WorkerParameters workerParams,
      AlertRepository alertRepository) {
    return new AlertExpiryWorker(context, workerParams, alertRepository);
  }
}
