package git.commit_jgit;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;


public class Test03_pull_repository {
	public static void main(String[] args) throws IOException, InvalidRemoteException, TransportException, GitAPIException {
	
		
		String REMOTE_URL = "https://github.com/jungwoonshin/pull_test.git";
		String LOCAL_PATH = "/Users/jungwoonshin/git/cloned_git";
		File localPath = new File(LOCAL_PATH+"/.git");

		// open the created repository that is in local disk
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		Repository repository = builder.setGitDir(localPath)
				.readEnvironment() // scan environment GIT_* variables
				.findGitDir() // scan up the file system tree
				.build();


        System.out.println("Having repository: " + repository.getDirectory() + " with head: " +
                repository.getRef(Constants.HEAD) + "/" + repository.resolve("HEAD") + "/" +
                repository.resolve("refs/heads/master"));

        // TODO: why do we get null here for HEAD?!? See also
// http://stackoverflow.com/questions/17979660/jgit-pull-noheadexception

        PullResult call = new Git(repository).pull().call();

        System.out.println("Pulled from the remote repository: " + call);

        repository.close();
        
        
		
		
        // credentials
		String name = "jungwoonshin";
        String password = "**";
        CredentialsProvider cp = new UsernamePasswordCredentialsProvider(name, password);
        
        
        
        
        


	}
}
