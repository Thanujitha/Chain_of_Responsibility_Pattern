Use the Chain of Responsibility Pattern When you want to give more than one object a chance to handle a request.

**Handler- ** 
  HAS-A (Protected Handler)
  SetHandler(Handler handler)
  abstract void process(Client client)
