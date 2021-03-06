package ujson

import scala.util.Try

class FileSyntaxCheck extends SyntaxCheck {
  override def isValidSyntax(s: String): Boolean = {
    TestUtil.withTemp(s) { t =>
      Try(Transformable.fromFile(t).transform(NoOpVisitor)).isSuccess
    }
  }
}
