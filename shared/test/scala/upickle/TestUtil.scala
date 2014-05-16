package upickle
import utest._
/**
 * Created by haoyi on 4/22/14.
 */
object TestUtil {
  def rw[T: Reader: Writer](t: T, s: String = null) = {
    rwk[T, T](t, s)(t => t)
  }
  def rwk[T: Reader: Writer, V](t: T, sIn: String = null)(k: T => V) = {
    val writtenT = write(t)
    val s = if (sIn == null) writtenT else sIn.trim
    val readS = read[T](s)

    assert(
      writtenT == s,
      k(readS) == k(t)
    )
  }
}