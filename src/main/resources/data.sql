-- 初期ユーザーデータの投入 --
INSERT INTO users (email, password, name, role)
VALUES ('asakura@example.com','0000','朝倉シン','USER');
ON CONFLICT (email) DO NOTHING;

INSERT INTO users (email, password, name, role)
VALUES ('sakamoto@example.com','1111','坂本太郎','ADMIN');
ON CONFLICT (email) DO NOTHING;

-- テスト用日報データの投入
INSERT INTO report (work_date, work_hours, content, impressions)
VALUES ('2026-09-01', 8.0, 'Spring BootとH2データベースの設定作業。環境構築を完了した。', 'H2での動作確認がスムーズに行えた。');

INSERT INTO report (work_date, work_hours, content, impressions)
VALUES ('2026-09-02', 7.5, 'React側のフォーム入力とAPI連携テスト。', 'データの疎通確認ができた。');