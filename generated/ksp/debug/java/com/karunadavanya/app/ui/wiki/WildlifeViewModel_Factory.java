package com.karunadavanya.app.ui.wiki;

import com.karunadavanya.app.data.repository.WildlifeRepository;
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
public final class WildlifeViewModel_Factory implements Factory<WildlifeViewModel> {
  private final Provider<WildlifeRepository> wildlifeRepositoryProvider;

  public WildlifeViewModel_Factory(Provider<WildlifeRepository> wildlifeRepositoryProvider) {
    this.wildlifeRepositoryProvider = wildlifeRepositoryProvider;
  }

  @Override
  public WildlifeViewModel get() {
    return newInstance(wildlifeRepositoryProvider.get());
  }

  public static WildlifeViewModel_Factory create(
      Provider<WildlifeRepository> wildlifeRepositoryProvider) {
    return new WildlifeViewModel_Factory(wildlifeRepositoryProvider);
  }

  public static WildlifeViewModel newInstance(WildlifeRepository wildlifeRepository) {
    return new WildlifeViewModel(wildlifeRepository);
  }
}
