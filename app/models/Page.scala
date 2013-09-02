package models

/**
 * Helper for pagination
 */
case class Page[A](
    items: Seq[A],
    totalResults: Long,
    startIndex: Long = 0,
    itemsPerPage: Int = 10) {

  lazy val prevIndex  = Option(startIndex - itemsPerPage).filter(_ >= 0)
  lazy val nextIndex  = Option(startIndex + itemsPerPage).filter(_ < totalResults)
  lazy val totalPages = (totalResults / itemsPerPage) +
                          ((totalResults % itemsPerPage) min 1)

  /** For view start position in the page. */
  def start = startIndex + 1

  /** For view end position in the page. */
  def end   = startIndex + items.length
}