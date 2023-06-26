package jp.co.yumemi.android.codecheck.ui

import android.widget.ImageView
import coil.load
import javax.inject.Inject

/**
 * 画像の読み込みを行うためのinterface
 */
interface ImageLoader {
  @JvmInline
  value class ImageUrl(val value: String)

  interface Builder {
    /**
     * 画像をロードする
     */
    fun load(imageUrl: ImageUrl): Builder

    /**
     * [imageView]に画像を読み込む
     */
    fun into(imageView: ImageView)
  }

  /**
   * 画像をロードする
   */
  fun load(imageUrl: ImageUrl): Builder
}

class ImageLoaderImpl @Inject constructor() : ImageLoader {
  override fun load(
    imageUrl: ImageLoader.ImageUrl,
  ) : ImageLoader.Builder {
    return ImageLoaderBuilder().also {
      it.load(imageUrl = imageUrl)
    }
  }
}

class ImageLoaderBuilder : ImageLoader.Builder {
  private var imageUrl: ImageLoader.ImageUrl? = null

  override fun load(imageUrl: ImageLoader.ImageUrl):ImageLoader.Builder {
    this.imageUrl = imageUrl
    return this
  }

  override fun into(imageView: ImageView) {
    val imageUrl = imageUrl
      ?: throw IllegalStateException("image url is not set!")
    imageView.load(imageUrl.value)
  }
}
