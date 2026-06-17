package com.base.app.ui.detail;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class DetailViewModel_Factory implements Factory<DetailViewModel> {
  @Override
  public DetailViewModel get() {
    return newInstance();
  }

  public static DetailViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DetailViewModel newInstance() {
    return new DetailViewModel();
  }

  private static final class InstanceHolder {
    private static final DetailViewModel_Factory INSTANCE = new DetailViewModel_Factory();
  }
}
