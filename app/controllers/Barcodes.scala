package controllers

import play.api.mvc.{Action, Controller}

object Barcodes extends Controller {
  val ImageResolution = 144
  val mimeType = "image/png"

  def barcode(ean: String) = Action {
    import java.lang.IllegalArgumentException

    try {
      val imageData = ean13Barcode(ean, mimeType);
      Ok(imageData).as(mimeType)
    } catch {
      case e: IllegalArgumentException =>
        BadRequest("Could not generate bar code: Error: " + e.getMessage())
    }
  }

  def ean13Barcode(ean: String, mimeType: String) : Array[Byte] = {
    import java.io.ByteArrayOutputStream
    import java.awt.image.BufferedImage
    import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider
    import org.krysalis.barcode4j.impl.upcean.EAN13Bean

    val output = new ByteArrayOutputStream
    val canvas = new BitmapCanvasProvider(output, mimeType, ImageResolution, BufferedImage.TYPE_BYTE_BINARY, true, 0)
    val barcode = new EAN13Bean
    barcode.generateBarcode(canvas, ean)
    canvas.finish()
    val result = output.toByteArray
    output.close()
    result
  }
}
