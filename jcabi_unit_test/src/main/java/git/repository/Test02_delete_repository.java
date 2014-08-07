package git.repository;

import org.apache.commons.lang3.RandomStringUtils;

import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.RtGithub;

public class Test02_delete_repository{
	//	static Logger logger;
	static String user = "maverickjin8";
	static String password = "snorlax1";
	static String[] repository_Delete = {"repo-name6","repo-name5","repo-name4","repo-nam3","test","repo-name2","repo-name","walar","testerzz","testerz"};

	public static void main(String[] args) throws Exception {
		Github github = new RtGithub("maverickjin8","snorlax1");
		Coordinates.Simple repositoryToBeRemoved = new Coordinates.Simple(user,repository_Delete[0]);
		Coordinates.Simple repositoryToBeRemoved1 = new Coordinates.Simple(user,repository_Delete[1]);
		Coordinates.Simple repositoryToBeRemoved2 = new Coordinates.Simple(user,repository_Delete[2]);
		Coordinates.Simple repositoryToBeRemoved3 = new Coordinates.Simple(user,repository_Delete[3]);
		Coordinates.Simple repositoryToBeRemoved4 = new Coordinates.Simple(user,repository_Delete[4]);
		Coordinates.Simple repositoryToBeRemoved5 = new Coordinates.Simple(user,repository_Delete[5]);
		Coordinates.Simple repositoryToBeRemoved6 = new Coordinates.Simple(user,repository_Delete[6]);
		Coordinates.Simple repositoryToBeRemoved7 = new Coordinates.Simple(user,repository_Delete[7]);
		Coordinates.Simple repositoryToBeRemoved8 = new Coordinates.Simple(user,repository_Delete[8]);
		Coordinates.Simple repositoryToBeRemoved9 = new Coordinates.Simple(user,repository_Delete[9]);
		System.out.println("=================================================================================");
		
		//리파지토리 삭제하기
		github.repos().remove(repositoryToBeRemoved);
		github.repos().remove(repositoryToBeRemoved1);
		github.repos().remove(repositoryToBeRemoved2);
		github.repos().remove(repositoryToBeRemoved3);
		github.repos().remove(repositoryToBeRemoved4);
		github.repos().remove(repositoryToBeRemoved5);
		github.repos().remove(repositoryToBeRemoved6);
		github.repos().remove(repositoryToBeRemoved7);
		github.repos().remove(repositoryToBeRemoved8);
		github.repos().remove(repositoryToBeRemoved9);
		
	}


    /**
     * Generate a random fake SHA hex string.
     *
     * @return Fake SHA string.
     */
    private static String fakeSha() {
        // @checkstyle MagicNumberCheck (1 line)
        return RandomStringUtils.random(40, "0123456789abcdef");
    }
}