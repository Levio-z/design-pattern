- 假设我们有一个比较复杂的对话框，对话框中有很多控件，比如按钮、文本框、下拉框等。
当我们对某个控件进行操作的时候，其他控件会做出相应的反应，比如，我们在下拉框中选
择“注册”，注册相关的控件就会显示在对话框中。如果我们在下拉框中选择“登陆”，登
陆相关的控件就会显示在对话框中。
按照通常我们习惯的 UI 界面的开发方式，我们将刚刚的需求用代码实现出来，就是下面这
个样子。在这种实现方式中，控件和控件之间互相操作、互相依赖。
使用中介模式，我们可以将各个控件的交互逻辑，统一交给一个中介对象来处理。
- 在新的代码实现中，各个控件只跟中介对象交互，中介对象负责所有业务逻辑的处理。
- 从代码中我们可以看出，原本业务逻辑会分散在各个控件中，现在都集中到了中介类中。实
际上，这样做既有好处，也有坏处。好处是简化了控件之间的交互，坏处是中介类有可能会
变成大而复杂的“上帝类”（God Class）。所以，在使用中介模式的时候，我们要根据实
际的情况，平衡对象之间交互的复杂度和中介类本身的复杂度。