public class UseMessenger {
        public static void main(String[] args) {
            Person pepe = new Person("Pepe", "5555380");
            Person juan = new Person("Juan", "55541501");
            Person antonio = new Person("Antonio", "5556380");
            Person maría = new Person("María", "5557780");
            Person ana = new Person("Ana", "5557781");
            Group familia = new Group("familia");
            Group amigos = new Group("amigos");
            Group amigas = new Group("amigas");
            Group todos = new Group("todos");
            Group noFamilia = new Group("no familiares");
            familia.add(juan);
            familia.add(maría);
            amigos.add(pepe);
            amigos.add(antonio);
            amigas.add(ana);
            noFamilia.add(amigos);
            noFamilia.add(amigas);
            todos.add(familia);
            todos.add(noFamilia);
            amigos.add(todos);
            noFamilia.remove(pepe.getId());
            amigas.remove(ana.getId());
        }
}