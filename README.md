# ソフトウェア制作用

## 独り言
(6/1)
・特に変わってない。今までのやつをクラスにわけてGUIのときになるべく分裂できるようにした。  
・やっぱりCUIができないとお話にならなそう。中間報告にはCUIを完成させたい。  
・僕の明日までの目標はサーバーに送られてきたやつを全員のクライアントに表示できるようにする。  
・まさあきとりょうごにもついに仕事を分けたいと思うからアウトラインのPDFを読んでくれ。コードの説明は分からなかったら言ってくれ。  
(5/24)  
・３つ目のやつが多分今回のソフトウェアの原型になると思う。まさきとかまさのりに言われたけどある程度原型ができてきたらいったんクラスごとに分けてみるといいみたい。  
・あとGUIってCUIにあとからくっつけられるのかと思ってたけどどうやらいきなりGUIで作ってもいいみたいだからこれはまた後で考える。  
・僕の次のタスクはクラス考えてできればみんなに割り振れるよう努力します。  


## 授業のメモ
[第１回](./softmemo.txt)  

## アウトライン
[Outline](./Outline2.pdf)  

## 複数のコマンドプロンプトからの送受信可能なプログラム例
[サーバー：MultiServerSample.java](./MultiServerSample.java)  
[クライアント：MultiClientSample.java](./MultiClientSample.java)  

・“java MultiServerSample でサーバーを立てる。  
・複数のコマンドプロンプトから“java MultiClientSample localhost "好きな文字"”でメッセージを送信。

## １対１で複数の文字列をサーバーに書き込み
[サーバー：JabberServer.java](./JabberServer.java)  
[クライアント：JabberClient.java](./JabberClient.java)  

## １対多での複数の文字列をサーバーに送信
[サーバー：MultiServer.java](./MultiServer.java)  
[マルチスレッド：ServerThread.java](./ServerThread.java)  
[クライアント：MultiClient.java](./MultiClient.java)

## １対多での複数の文字列をサーバーに送信し、クライアントに送られたデータを返す
[サーバー：](./ChannelServer.java)  
[クライアント：](./ChannelClient.java)  
[読み書きクラス：](./ReadWrite.java)  
[データ送信クラス：](./SendThread.java)  
[サーバーのデータ表示クラス：](./PresentThread.java)  