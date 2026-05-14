package com.karunadavanya.app.data.repository;

import com.karunadavanya.app.data.local.dao.WildlifeDao;
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
public final class WildlifeRepository_Factory implements Factory<WildlifeRepository> {
  private final Provider<WildlifeDao> wildlifeDaoProvider;

  public WildlifeRepository_Factory(Provider<WildlifeDao> wildlifeDaoProvider) {
    this.wildlifeDaoProvider = wildlifeDaoProvider;
  }

  @Override
  public WildlifeRepository get() {
    return newInstance(wildlifeDaoProvider.get());
  }

  public static WildlifeRepository_Factory create(Provider<WildlifeDao> wildlifeDaoProvider) {
    return new WildlifeRepository_Factory(wildlifeDaoProvider);
  }

  public static WildlifeRepository newInstance(WildlifeDao wildlifeDao) {
    return new WildlifeRepository(wildlifeDao);
  }
}
