package files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirWalkSample {
	// ディレクトリ内の処理
	private static void subdir(Path path) {
		try(Stream<Path> stream = Files.list(path)){
			  stream.forEach(p -> {
				if (p.toFile().isDirectory()) {
					System.out.println("dir: " + p);
					subdir(p);
				} else {
					System.out.println("file: " + p);
				}
			  });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// 指定したディレクトリ内の探索
		subdir(Paths.get("/tmp/test"));
	}

}
