/* ユーザーマスタ */
CREATE TABLE IF NOT EXISTS m_user (
    user_id VARCHAR(50) PRIMARY KEY
  , password VARCHAR(100)
  , user_name VARCHAR(50)
);

/*会社マスター*/
CREATE TABLE IF NOT EXISTS company (
    company_id VARCHAR(50) PRIMARY KEY
  , company_name VARCHAR(100)
  , company_abstract VARCHAR(2000)
 
);

/*メモ マスター
ユーザマスター側をmap型にすると使わないかも?*/
CREATE TABLE IF NOT EXISTS user_company (
   user_id VARCHAR(50) 
  , company_id VARCHAR(50) 
  , company_memo VARCHAR(100)
  , PRIMARY KEY(user_id, company_id)

);