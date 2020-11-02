package steppanova.com.ua;

public class Test1 {

	public static void encrypt(String s, int n) {
		try {
			if (s.length() == 0 || s == null || n <= 0) {
				System.out.println(s);
				return;
			}
			System.out.print(s + "->");
			StringBuilder incoming = new StringBuilder(s);
			while (n > 0) {
				StringBuilder outgoing = new StringBuilder();
				for (int i = 0; i < incoming.length(); i++) {
					if (!(i % 2 == 0)) {
						char c = incoming.charAt(i);

						outgoing.append(c);
					}
				}

				for (int i = 0; i < incoming.length(); i++) {
					if (i % 2 == 0) {
						char c = incoming.charAt(i);

						outgoing.append(c);
					}
				}
				n--;
				System.out.print(outgoing.toString().toLowerCase());
				if (n > 0) {
					System.out.print("->");
				}
				incoming = new StringBuilder(outgoing);
				outgoing = null;

			}
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void decrypt(String s, int n) {
		try {
			if (s.length() == 0 || s == null || n <= 0) {
				System.out.println(s);
				return;
			}
			System.out.print(s + "->");
			StringBuilder incoming = new StringBuilder(s);
			while (n > 0) {
				StringBuilder outgoing = new StringBuilder();
				int a = 0;
				int b = 0;
				for (int i = 0; i < incoming.length(); i++) {
					if (i % 2 == 0) {
						char c = incoming.charAt((incoming.length() / 2) + a);
						a++;
						outgoing.append(c);
					}
					if (!(i % 2 == 0)) {
						char c = incoming.charAt(b);
						b++;
						outgoing.append(c);
					}
				}
				n--;
				System.out.print(outgoing.toString());
				if (n > 0) {
					System.out.print("->");
				}
				incoming = new StringBuilder(outgoing);
				outgoing = null;
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {

		encrypt(null, 3);
		decrypt("bdfhjacegi", 1);
		decrypt("dhaeibfjcg", 2);
		decrypt("hebjgdaifc", 3);
	}
}
