package com.karunadavanya.app.ui.sounds;

import com.karunadavanya.app.utils.ForestMediaPlayer;
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
public final class SoundsFragment_MembersInjector implements MembersInjector<SoundsFragment> {
  private final Provider<ForestMediaPlayer> mediaPlayerProvider;

  public SoundsFragment_MembersInjector(Provider<ForestMediaPlayer> mediaPlayerProvider) {
    this.mediaPlayerProvider = mediaPlayerProvider;
  }

  public static MembersInjector<SoundsFragment> create(
      Provider<ForestMediaPlayer> mediaPlayerProvider) {
    return new SoundsFragment_MembersInjector(mediaPlayerProvider);
  }

  @Override
  public void injectMembers(SoundsFragment instance) {
    injectMediaPlayer(instance, mediaPlayerProvider.get());
  }

  @InjectedFieldSignature("com.karunadavanya.app.ui.sounds.SoundsFragment.mediaPlayer")
  public static void injectMediaPlayer(SoundsFragment instance, ForestMediaPlayer mediaPlayer) {
    instance.mediaPlayer = mediaPlayer;
  }
}
