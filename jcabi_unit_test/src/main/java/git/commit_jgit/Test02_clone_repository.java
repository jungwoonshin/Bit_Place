package git.commit_jgit;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.errors.UnmergedPathException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class Test02_clone_repository {


	public static void main(String[] args) throws IOException, InvalidRemoteException, TransportException, GitAPIException {

		String REMOTE_URL = "https://github.com/jungwoonshin/pull_test.git";
		String LOCAL_PATH = "/Users/jungwoonshin/git/cloned_git";
		File localPath = new File(LOCAL_PATH+"/.git");

		// then clone
//		System.out.println("Cloning from " + REMOTE_URL + " to " + localPath);
//		Git.cloneRepository()
//		.setURI(REMOTE_URL)
//		.setDirectory(localPath)
//		.call();

		// now open the created repository that is in local disk
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		Repository repository = builder.setGitDir(localPath)
				.readEnvironment() // scan environment GIT_* variables
				.findGitDir() // scan up the file system tree
				.build();

		System.out.println("Having repository: " + repository.getDirectory());


		//end of cloning
		System.out.println("================================================================");

		//Get git object of local repository that was cloned in the previous stage
		Git git = new Git(repository);
		//        git.pull()
		//        	.call();
		//
		//        System.out.println("Pulled from remote repository to local repository at " + repository.getDirectory());
		//		System.out.println("================================================================");
		//
		//        Git git = new Git(repository);
		//        git.push()
		//                .call();
		//
		//        System.out.println("Pushed from repository: " + repository.getDirectory() + " to remote repository at " + REMOTE_URL);
		
		
		System.out.println("================================================================");
		//end of pull

		String name = "jungwoonshin";
		String password = "wjddns1025";

		// credentials
		CredentialsProvider cp = new UsernamePasswordCredentialsProvider(name, password);

		/*

        AddCommand ac = git.add();
        ac.addFilepattern("cloned_git/123.txt");
        try {
            ac.call();
        } catch (NoFilepatternException e) {
           e.printStackTrace();
        }
       git.add()
       .addFilepattern("123")
      .call();

        // commit
        CommitCommand commit = git.commit();
        commit.setCommitter("jungwoonshin", "jungwoonshin@gmail.com")
                .setMessage("push test");

        // push
        PushCommand pc = git.push();
        pc.setCredentialsProvider(cp)
                .setForce(true)
                .setPushAll();
        try {
            Iterator<PushResult> it = pc.call().iterator();
            if(it.hasNext()){
                System.out.println(it.next().toString());
            }
        } catch (InvalidRemoteException e) {
            e.printStackTrace();
        }
        System.out.println("complete");

        // cleanup
		 */


		// create the file
		System.out.println("repository.getDirectory().getParent(): " + repository.getDirectory().getParent());
		File myfile = new File(repository.getDirectory().getParent(), "testfile");
		myfile.createNewFile();

		// run the add
		git.add()
		.addFilepattern("1233")
		.call();

		// and then commit the changes
		git.commit()
		.setMessage("Added 1233 folder that includes 7.txt and 8.txt")
		.call();

		System.out.println("Committed file " + myfile + " to repository at " + repository.getDirectory());
		git.push()
		.setCredentialsProvider(cp)
		.setForce(true)
		.setPushAll()
		.call();

		System.out.println("Pushed from repository: " + repository.getDirectory() + " to remote repository at " + REMOTE_URL);

		repository.close();





	}
}
