package GenericTest;

import org.junit.Test;

import java.util.*;

/**
 * @author vdsklnl
 * @create 2022-04-18 20:06
 * @Description
 * 定义个泛型类 DAO<T>，在其中定义一个 Map 成员变量，Map 的键
 * 为 String 类型，值为 T 类型。
 *
 * 分别创建以下方法：
 * public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员
 * 变量中
 * public T get(String id)：从 map 中获取 id 对应的对象
 * public void update(String id,T entity)：替换 map 中 key 为 id 的内容,
 * 改为 entity 对象
 * public List<T> list()：返回 map 中存放的所有 T 对象
 * public void delete(String id)：删除指定 id 对象
 *
 * 定义一个 User 类：
 * 该类包含：private 成员变量（int 类型） id，age；（String 类型）name。
 *
 * 定义一个测试类：
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方
 * 法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 */

class DAO<T> {
    private Map<String,T> map = new HashMap<>();

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public DAO() {

    }

    public Map<String, T> getMap() {
        return map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }

    // 保存 T 类型的对象到 Map 成员变量中
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    // 从 map 中获取 id 对应的对象
    public T get(String id) {
        return map.get(id);
    }

    // 替换 map 中 key 为 id 的内容, 改为 entity 对象
    public void update(String id,T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    // 返回 map 中存放的所有 T 对象
    public List<T> list() {
//        错误生成Collection对象，无法(List<T>)进行强制转型
//        Collection<T> values = map.values();
//        return (List<T>) values;
        // 正确，遍历赋值
        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t:values) {
            list.add(t);
        }
        return list;
    }

    // 删除指定 id 对象
    public void delete(String id) {
        map.remove(id);
    }

}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }
}

public class DAOTest<T> {
    public static void main(String[] args) {

        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,23,"Alan"));
        dao.save("1002",new User(1002,25,"Ashley"));
        dao.save("1003",new User(1003,87,"Frank"));

        dao.update("1003",new User(1005,54,"Amen"));
        dao.delete("1002");

        List<User> list = dao.list();
        list.forEach(System.out::println);

        // 泛型遍历Entry
        Set<Map.Entry<String, User>> entries = dao.getMap().entrySet();
        Iterator<Map.Entry<String, User>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, User> entry = iterator.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }


    }

    @Test
    public void genericTest() {

    }
}


