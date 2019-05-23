# ソフトウェア制作用

## 独り言
(5/24)
・３つ目のやつが多分今回のソフトウェアの原型になると思う。まさきとかまさのりに言われたけどある程度原型ができてきたらいったんクラスごとに分けてみるといいみたい。  
・あとGUIってCUIにあとからくっつけられるのかと思ってたけどどうやらいきなりGUIで作ってもいいみたいだからこれはまた後で考える。
・僕の次のタスクはクラス考えてできればみんなに割り振れるよう努力します。


## 授業のメモ
[第１回](./softmemo.txt)

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
[クライアント：MultiClient.java](./MultiClient.java)