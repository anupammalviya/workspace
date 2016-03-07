
public class TestTest {
	public static void main(String[] args) {
		Test t = new Test("Abc", 11);
		t.setTest("ABC");
		t.setTestInt(11);
		Test t2 = (Test)t.clone();
	}
}
