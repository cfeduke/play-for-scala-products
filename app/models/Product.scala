package models

case class Product(ean: String, name: String, description: String)

object Product {
  var products = Set(
    Product("501022519181", "Paperclips Large", "Large plain pack of 1000"),
    Product("501022599992", "Giant Paperclips", "Giant plain 51mm 100 pack"),
    Product("501022639292", "Paperclip Giant Plain", "Giant plain pack of 10,000"),
    Product("501022631098", "Zebra Paperclips", "Zebra length 28mm assorted 150 pack"))

  def findAll = products.toList.sortBy(_.ean)

  def findByEan(ean: String) = products.find(_.ean == ean)
}
