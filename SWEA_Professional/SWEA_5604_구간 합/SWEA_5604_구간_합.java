import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class SWEA_5604_구간_합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static HashMap<Long, Long> map = new HashMap<Long, Long>();

	public static void main(String[] args) throws IOException {
		for (int i = 1; i < 17; i++) {
			long v = (long) Math.pow(10, i);
			map.put(v - 1L, h(v - 1L));
		}

		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			String[] str = br.readLine().split(" ");
			long A = Long.parseLong(str[0]);
			long B = Long.parseLong(str[1]);

			sb.append("#").append(t).append(" ").append(cal(B, A)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static long h(long n) {
		long len = len(n) + 1L;

		return (45L * len * (n + 1L)) / 10L;
	}

	public static long cal(long B, long A) {
		if (A <= 1) {
			return f(B);
		} else {
			return f(B) - f(A - 1);
		}
	}

	static long f(long n) {
		if (map.containsKey(n)) {
			return map.get(n);
		} else if (n <= 9) {
			return e(n);
		} else {
			long v = pow10(len(n));
			map.put(n, f(n - 1L - n % v) + g(n));
			return map.get(n);
		}
	}

	static long g(long n) {
		if (n <= 9)
			return e(n);
		else {
			long v = pow10(len(n));
			return (n / v) * (n % v + 1L) + f(n % v);
		}
	}

	static long e(long n) {
		return n * (n + 1L) / 2L;
	}

	static long len(long n) {
		return 0L + (n + "").length() - 1;
	}

	static long pow10(long n) {
		return (long) Math.pow(10, n);
	}
}
