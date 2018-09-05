# MessageCarrier
Use android native broadcast mechanism to communicate with each View.

## Usage

### Dependencies 
```
implementation 'com.shindi.tools:messagecarrier:1.0.0' (Temporary. Not publish yet)
```

### Receiver
```java
MsgReceiver receiver = new MsgReceiver(getApplicationContext(), YOUR_FILTER_ACTION);
receiver.setOnReceiverListener(new ReceiveListener() {
    @Override
    public void onReceive(Message message) {

    }
});
```
After initialize receiver, don't forget call 'register' function
```java
receiver.register();
```
When view closed, you should call 'release' in onDestroy override function
```java
@Override
public void onDestroy(){
    if (receiver != null) receiver.release();
    super.onDestroy();
}
```

### Sender
```java
MsgSender ms = new MsgSender(getApplicationContext(), YOUR_FILTER_ACTION);
ms.send("Hello Carrier~");
```
We support four types of Message
* String
* Integer
* Boolean
* Bundle
        
        
        
