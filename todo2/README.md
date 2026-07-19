# ToDo アプリケーション

このアプリケーションはSpring BootとH2 Databaseを使用したシンプルなToDo管理アプリケーションです。

## 機能

- ToDoの作成、表示、編集、削除
- データベースとしてH2を使用
- レイアウトとしてThymeleafを使用
- ログ出力機能付き

## 技術スタック

- **言語**: Java 21
- **フレームワーク**: Spring Boot 3.4.0
- **データベース**: H2 Database 2.2.224
- **テンプレートエンジン**: Thymeleaf
- **UIフレームワーク**: Bootstrap 5.3.0

## プロジェクト構造

```
.
├── pom.xml                 # Mavenビルド設定
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/todo/
│       │       ├── TodoApplication.java    # アプリケーション起動クラス
│       │       ├── controller/             # コントローラー
│       │       ├── model/                  # モデルクラス
│       │       └── repository/             # リポジトリ
│       └── resources/
│           ├── application.properties      # 設定ファイル
│           └── templates/                  # Thymeleafテンプレート
└── logs/                   # ログ出力ディレクトリ
```

## 設定

### データベース設定
- H2メモリデータベースを使用
- H2コンソールは `/h2-console` で利用可能

### ポート設定
- アプリケーション: 8080番ポート
- H2コンソール: 8080番ポート

### ログ設定
- ログファイル: `logs/application.log`
- ログレベル: INFO

## ビルド方法

```bash
mvn clean package
```

## 実行方法

```bash
java -jar target/todo-app-0.0.1-SNAPSHOT.jar
```

実行後、以下のURLにアクセスできます：
- アプリケーション: http://localhost:8080
- H2コンソール: http://localhost:8080/h2-console

## 開発者向け情報

### データベース接続情報
H2コンソールにアクセスするには、以下の情報を使用します：
- JDBC URL: `jdbc:h2:mem:testdb`
- ユーザー名: `sa`
- パスワード: （空）

### テンプレートファイル
- `index.html`: ToDo一覧画面
- `create.html`: ToDo作成画面
- `edit.html`: ToDo編集画面
- `layout.html`: 共通レイアウト

### ログ出力
アプリケーション実行時に`logs`ディレクトリにログファイルが出力されます。