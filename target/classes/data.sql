/* ユーザーマスタ */
INSERT INTO m_user (
    user_id 
  , password
  , user_name 

) VALUES
('id1', 'id1','ID1')
,('id2', 'id2','ID2')
;

/* 会社マスタ */
INSERT INTO company (
  company_id
  , company_name 
  , company_abstract 

) VALUES
('company1', 'マクロコスモス','ガラル地方のポケモンリーグ委員長のローズが経営する企業グループ（所謂財閥）。ポケモンリーグの筆頭スポンサーでもある。ちなみにマクロコスモスとは「大宇宙」の意味。 (後述の活躍から「黒幕」にもかけているものと思われる。) 事業は建設業、保険業、航空業など多岐にわたっており、ローズタワーにはマクロコスモス関連企業が多く入居している。関連会社の一つマクロコスモス・コンストラクションはポケモン勝負が可能なエレベータの開発など高い技術力を持っている。 
中盤以降はポケジョブの募集要項にも幾つか顔を出すようになる。 「マクロ」が名前に含まれる組織は共通して「C」の字を元にしたロゴマークとなっている。 ')
,('company2', '竹書房','竹書房ゥァア゛ーッ')
;

/* メモマスタ */
INSERT INTO user_company (
    user_id
   , company_id 
   , company_memo 
   

) VALUES
('id1', 'company1','内定承諾')
,('id2', 'company2','もしもしポリスメン?')
,('id1', 'company2','蒼井翔太')
,('id2', 'company1','巨大マックス')
;
