package models

case class Product(
  ean: Long, name: String, description: String)

object Product {
  var products = Set(
    Product(501022519181L, "Paperclips Large", "Large plain pack of 1000"),
    Product(501022599992L, "Giant Paperclips", "Giant plain 51mm 100 pack"),
    Product(501022639292L, "Paperclip Giant Plain", "Giant plain pack of 10,000"),
    Product(501022631098L, "Zebra Paperclips", "Zebra length 28mm assorted 150 pack"))

  def findAll = this.products.toList.sortBy(_.ean)
}
