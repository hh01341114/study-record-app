# study-record-ap
# 学習記録アプリ

学習の進捗・時間・内容を記録・可視化し、学習目標の達成とモチベーションの維持を支援するWebアプリケーションです。

## 機能一覧

- **ダッシュボード** - 学習時間・タスク進捗・カレンダー表示
- **学習記録** - 日付・時間・内容・学習サイト・テーマの登録と一覧表示
- **タスク管理** - タスクの登録・期限・優先度・ステータス管理
- **プロフィール** - ユーザー情報・目標設定

## 技術スタック

| カテゴリ | 技術 |
|---|---|
| バックエンド | Java 21 / Spring Boot 3.5.11 |
| フロントエンド | Thymeleaf |
| データベース | PostgreSQL |
| ORM | Spring Data JPA |
| セキュリティ | Spring Security |
| ビルドツール | Gradle |

## ブランチ戦略

| ブランチ | 役割 |
|---|---|
| `main` | 動作する状態のコードを管理 |
| `feature/xxx` | 機能ごとに作成しmainにマージ |

## 環境構築

### 前提条件

- Java 21
- PostgreSQL
- Gradle

### セットアップ手順

1. リポジトリをクローン
```bash
git clone https://github.com/your-username/study-record-app.git
cd study-record-app
```

2. データベースを作成
```sql
CREATE DATABASE study_record;
```

3. `application.properties` にDB接続情報を設定
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/study_record
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. アプリケーションを起動
```bash
./gradlew bootRun
```

5. ブラウザで確認
```
http://localhost:8080
```

## DB設計

| テーブル名 | 役割 |
|---|---|
| users | ユーザー管理 |
| tasks | タスク管理 |
| task_priorities | 優先度マスタ（高・中・低） |
| task_statuses | ステータスマスタ（未着手・進行中・完了・保留） |
| study_records | 学習記録 |
| learning_sites | 学習サイトマスタ |
| learning_themes | 学習テーママスタ |p
