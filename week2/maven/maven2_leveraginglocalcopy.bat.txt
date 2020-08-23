mvn -Dmaven.repo.local=$HOME/.my/other/repository clean install

_______________________________________________________

Maven local repository reside in the developer’s machine. Whenever you run maven goals which require these dependencies, maven will download the dependencies from remote servers and store them into developer’s machine.

By default, Maven create the local repository inside user home directory i.e. C:/Users/superdev/.m2 directory. You can change the location of the local repository in setting.xml file using localRepository tag.

Having stored the dependencies into local machine has two main benefits. 
First, multiple projects can access same artifact so it reduces the storage need. 
Second, as dependency is downloaded only once, it reduces the network usage as well.

________________________________________________________