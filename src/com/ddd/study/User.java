package com.ddd.study;

/**
 * ユーザー
 */
public final class User {

    /** ユーザーID */
    private final UserId id;

    /** ユーザー名 */
    private String name;

    /**
     * コンストラクタ
     * @param id ユーザーID
     * @param name ユーザー名
     */
    public User(final UserId id, final String name) {

        if (id == null) throw new IllegalArgumentException("ユーザーIDが設定されていません。");

        this.id = id;
        this.changeUserName(name);
    }

    /**
     * ユーザー名を変更する
     * @param name ユーザー名
     */
    public void changeUserName(String name) {

        if (name == null) throw new IllegalArgumentException("ユーザー名が設定されていません。");
        if (name.length() < 3) throw new IllegalArgumentException("ユーザー名は3文字以上です。");

        this.name = name;
    }

    public UserId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

