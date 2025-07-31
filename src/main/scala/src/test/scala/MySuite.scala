// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
  test("example that not fails"){
    val obtained = 0
    val expected = 0
    assertEquals(obtained, expected)
  }
}
