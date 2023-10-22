package studentsystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//import static sun.security.jgss.GSSUtil.login;

/**
 * @Auther cxg
 * @DAte 2023/10/19
 */
public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<User> list=new ArrayList<>();
        while(true){
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作：1登录 2注册 3忘记密码");
            String choose=sc.next();
            switch(choose){
                case "1"-> login(list);
                case "2"-> register(list);
                case "3"-> fogetpassword(list);
                case "4"->{
                    System.out.println("感谢使用，再见");
                    System.exit(0);
                }
                default -> System.out.println("无这个选项");
            }
        }
    }

    private static void fogetpassword(ArrayList<User> list) {
       // System.out.println("忘记密码");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的用户名");
        String username=sc.next();
        System.out.println("请输入你的身份证号码");
        String personid=sc.next();
        System.out.println("请输入你的电话号码");
        String phonenum=sc.next();
        int index=findindex(list,username);
        User user=list.get(index);
        if(!((user.getPersonid().equalsIgnoreCase(personid))&&(user.getPhonenum().equalsIgnoreCase(phonenum)))){
            System.out.println("身份证或电话号码有误，不能改");
            return;
        }
        String password;
        while(true){
            System.out.println("请输入新密码");
            password=sc.next();
            System.out.println("再次输入密码");
            String againpass=sc.next();
            if(password.equals(againpass)){
                System.out.println("两次密码一致");
                break;
            }else{
                System.out.println("密码不一致，重新输入");
            }
        }
        user.setPassword(password);
        System.out.println("密码修改成功");
    }

    private static int findindex(ArrayList<User> list,String username) {
        for (int i = 0; i < list.size(); i++) {
            User user=list.get(i);
            if(user.getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }

    private static void register(ArrayList<User> list) {
        Scanner sc=new Scanner(System.in);
        String username;
        String password;
        String personid;
        String phonenum;
        while(true){
            System.out.println("请输入用户名：");
            username=sc.next();
            Boolean flag1=checkusername(username);
            if(!flag1){
                System.out.println("用户名格式错误");
            }

            Boolean flag2=contain(list,username);
            if(flag2){
                System.out.println("用户名"+username+"可用");
                break;
            }
            else{
                System.out.println("用户名"+username+"已存在，重新输入");
            }
        }
        while (true) {
            System.out.println("请输入要注册的密码：");
            password=sc.next();
            System.out.println("再次输入您的密码");
            String againpass=sc.next();
            if(password.equals(againpass)){
                System.out.println("两次密码一致，继续录入其他数据");
                break;
            }
            else{
                System.out.println("两次密码不一致，请重新输入");
                continue;
            }
        }
        while (true) {
            System.out.println("请输入你的身份证号码：");
            personid=sc.next();
            Boolean flag3=checkpersonid(personid);
            if(flag3){
                System.out.println("你输入的身份证合法");
                break;
            }else{
                System.out.println("你的身份证不合法，请重新输入");
            }
        }
        while (true) {
            System.out.println("请输入你的电话号码：");
            phonenum=sc.next();
            Boolean flag4=checkphonenum(phonenum);
            if(flag4){
                System.out.println("你输入的电话号码合法");
                break;
            }else{
                System.out.println("你输入的电话号码不合法，请重新输入");
            }
        }
        User u=new User(username,password,personid,phonenum);
        list.add(u);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getUsername()+" "+list.get(i).getPassword()+" "+
                    list.get(i).getPersonid()+" "+list.get(i).getPhonenum());
        }
    }

    private static Boolean checkphonenum(String phonenum) {
        if(phonenum.length()!=11){
            return false;
        }
        if(phonenum.startsWith("0")){
            return false;
        }
        for(int i=0;i<phonenum.length();i++){
            char c=phonenum.charAt(i);
            if(!(c>='0'&&c<='9')){
                return false;
            }
        }
        return true;
    }

    private static Boolean checkpersonid(String personid) {
        if(personid.length()!=18){
            return false;
        }
        if(personid.startsWith("0")){
            return false;
        }
        for(int i=0;i<personid.length()-1;i++){
            char c=personid.charAt(i);
            if(!(c>='0'&&c<='9')){
                return false;
            }
        }
        char endchar=personid.charAt(personid.length()-1);
        if((endchar=='x')||(endchar=='X')||(endchar>='0'&&endchar<='9')){
            return true;
        }else{
            return false;
        }

    }

    private static Boolean contain(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User u=list.get(i);
            String user=u.getUsername();
            if(user.equals(username)){
                return false;
            }
        }
        return true;
    }

    private static Boolean checkusername(String username) {
        int len=username.length();
        if(len<3||len>15){
            return false;
        }
        for(int i=0;i<username.length();i++){
            char c=username.charAt(i);
            if(!((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))){
                return false;
            }
        }
        int count=0;
        for(int i=0;i<username.length();i++){
            char c=username.charAt(i);
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
            {
                count++;
                break;
            }
        }
        return count>0;
    }

    private static void login(ArrayList<User> list) {
        //System.out.println("登录");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.next();
        Boolean flag1=contain(list,username);
        if(flag1){
            System.out.println("用户名"+username+"未注册，请先注册");
        }
        System.out.println("请输入密码");
        String password=sc.next();

        while (true) {
            String rightcode=Getcode();
            System.out.println("验证码为"+rightcode);
            String code=sc.next();
            if(code.equalsIgnoreCase(rightcode)){
                System.out.println("验证码正确");
                break;
            }else{
                System.out.println("验证码错误");
            }
        }
        User u=new User(username,password,null,null);
        Boolean result=checkuserinfo(list,u);
        if(result){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败，用户名或密码错误");
        }
    }

    private static Boolean checkuserinfo(ArrayList<User>list,User userinfo) {
        for (int i = 0; i < list.size(); i++) {
            User u=list.get(i);
            if(u.getUsername().equals(userinfo.getUsername())&&u.getPassword().equals(userinfo.getPassword())){
                return true;
            }
        }
        return false;
    }

    private static String Getcode(){
        ArrayList<Character> list=new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<4;i++){
            int index=r.nextInt(list.size());
            char c=list.get(index);
            sb.append(c);
        }
        int num=r.nextInt(10);
        sb.append(num);
        char[]arr=sb.toString().toCharArray();
        int indextemp=r.nextInt(arr.length);
        char temp=arr[arr.length-1];
        arr[arr.length-1]=arr[indextemp];
        arr[indextemp]=temp;
        return new String(arr);
    }
}
