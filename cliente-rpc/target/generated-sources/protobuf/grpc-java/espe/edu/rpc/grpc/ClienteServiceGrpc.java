package espe.edu.rpc.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: cliente.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ClienteServiceGrpc {

  private ClienteServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "cliente.ClienteService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteRequest,
      espe.edu.rpc.grpc.ClienteResponse> getCrearClienteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CrearCliente",
      requestType = espe.edu.rpc.grpc.ClienteRequest.class,
      responseType = espe.edu.rpc.grpc.ClienteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteRequest,
      espe.edu.rpc.grpc.ClienteResponse> getCrearClienteMethod() {
    io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteRequest, espe.edu.rpc.grpc.ClienteResponse> getCrearClienteMethod;
    if ((getCrearClienteMethod = ClienteServiceGrpc.getCrearClienteMethod) == null) {
      synchronized (ClienteServiceGrpc.class) {
        if ((getCrearClienteMethod = ClienteServiceGrpc.getCrearClienteMethod) == null) {
          ClienteServiceGrpc.getCrearClienteMethod = getCrearClienteMethod =
              io.grpc.MethodDescriptor.<espe.edu.rpc.grpc.ClienteRequest, espe.edu.rpc.grpc.ClienteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CrearCliente"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  espe.edu.rpc.grpc.ClienteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  espe.edu.rpc.grpc.ClienteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ClienteServiceMethodDescriptorSupplier("CrearCliente"))
              .build();
        }
      }
    }
    return getCrearClienteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteIdRequest,
      espe.edu.rpc.grpc.ClienteResponse> getObtenerClienteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ObtenerCliente",
      requestType = espe.edu.rpc.grpc.ClienteIdRequest.class,
      responseType = espe.edu.rpc.grpc.ClienteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteIdRequest,
      espe.edu.rpc.grpc.ClienteResponse> getObtenerClienteMethod() {
    io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteIdRequest, espe.edu.rpc.grpc.ClienteResponse> getObtenerClienteMethod;
    if ((getObtenerClienteMethod = ClienteServiceGrpc.getObtenerClienteMethod) == null) {
      synchronized (ClienteServiceGrpc.class) {
        if ((getObtenerClienteMethod = ClienteServiceGrpc.getObtenerClienteMethod) == null) {
          ClienteServiceGrpc.getObtenerClienteMethod = getObtenerClienteMethod =
              io.grpc.MethodDescriptor.<espe.edu.rpc.grpc.ClienteIdRequest, espe.edu.rpc.grpc.ClienteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ObtenerCliente"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  espe.edu.rpc.grpc.ClienteIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  espe.edu.rpc.grpc.ClienteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ClienteServiceMethodDescriptorSupplier("ObtenerCliente"))
              .build();
        }
      }
    }
    return getObtenerClienteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<espe.edu.rpc.grpc.Empty,
      espe.edu.rpc.grpc.ClienteListResponse> getListarClientesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListarClientes",
      requestType = espe.edu.rpc.grpc.Empty.class,
      responseType = espe.edu.rpc.grpc.ClienteListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<espe.edu.rpc.grpc.Empty,
      espe.edu.rpc.grpc.ClienteListResponse> getListarClientesMethod() {
    io.grpc.MethodDescriptor<espe.edu.rpc.grpc.Empty, espe.edu.rpc.grpc.ClienteListResponse> getListarClientesMethod;
    if ((getListarClientesMethod = ClienteServiceGrpc.getListarClientesMethod) == null) {
      synchronized (ClienteServiceGrpc.class) {
        if ((getListarClientesMethod = ClienteServiceGrpc.getListarClientesMethod) == null) {
          ClienteServiceGrpc.getListarClientesMethod = getListarClientesMethod =
              io.grpc.MethodDescriptor.<espe.edu.rpc.grpc.Empty, espe.edu.rpc.grpc.ClienteListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListarClientes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  espe.edu.rpc.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  espe.edu.rpc.grpc.ClienteListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ClienteServiceMethodDescriptorSupplier("ListarClientes"))
              .build();
        }
      }
    }
    return getListarClientesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteRequest,
      espe.edu.rpc.grpc.BoolResponse> getActualizarClienteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActualizarCliente",
      requestType = espe.edu.rpc.grpc.ClienteRequest.class,
      responseType = espe.edu.rpc.grpc.BoolResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteRequest,
      espe.edu.rpc.grpc.BoolResponse> getActualizarClienteMethod() {
    io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteRequest, espe.edu.rpc.grpc.BoolResponse> getActualizarClienteMethod;
    if ((getActualizarClienteMethod = ClienteServiceGrpc.getActualizarClienteMethod) == null) {
      synchronized (ClienteServiceGrpc.class) {
        if ((getActualizarClienteMethod = ClienteServiceGrpc.getActualizarClienteMethod) == null) {
          ClienteServiceGrpc.getActualizarClienteMethod = getActualizarClienteMethod =
              io.grpc.MethodDescriptor.<espe.edu.rpc.grpc.ClienteRequest, espe.edu.rpc.grpc.BoolResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ActualizarCliente"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  espe.edu.rpc.grpc.ClienteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  espe.edu.rpc.grpc.BoolResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ClienteServiceMethodDescriptorSupplier("ActualizarCliente"))
              .build();
        }
      }
    }
    return getActualizarClienteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteIdRequest,
      espe.edu.rpc.grpc.BoolResponse> getEliminarClienteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EliminarCliente",
      requestType = espe.edu.rpc.grpc.ClienteIdRequest.class,
      responseType = espe.edu.rpc.grpc.BoolResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteIdRequest,
      espe.edu.rpc.grpc.BoolResponse> getEliminarClienteMethod() {
    io.grpc.MethodDescriptor<espe.edu.rpc.grpc.ClienteIdRequest, espe.edu.rpc.grpc.BoolResponse> getEliminarClienteMethod;
    if ((getEliminarClienteMethod = ClienteServiceGrpc.getEliminarClienteMethod) == null) {
      synchronized (ClienteServiceGrpc.class) {
        if ((getEliminarClienteMethod = ClienteServiceGrpc.getEliminarClienteMethod) == null) {
          ClienteServiceGrpc.getEliminarClienteMethod = getEliminarClienteMethod =
              io.grpc.MethodDescriptor.<espe.edu.rpc.grpc.ClienteIdRequest, espe.edu.rpc.grpc.BoolResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EliminarCliente"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  espe.edu.rpc.grpc.ClienteIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  espe.edu.rpc.grpc.BoolResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ClienteServiceMethodDescriptorSupplier("EliminarCliente"))
              .build();
        }
      }
    }
    return getEliminarClienteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClienteServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClienteServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClienteServiceStub>() {
        @java.lang.Override
        public ClienteServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClienteServiceStub(channel, callOptions);
        }
      };
    return ClienteServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClienteServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClienteServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClienteServiceBlockingStub>() {
        @java.lang.Override
        public ClienteServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClienteServiceBlockingStub(channel, callOptions);
        }
      };
    return ClienteServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClienteServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClienteServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClienteServiceFutureStub>() {
        @java.lang.Override
        public ClienteServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClienteServiceFutureStub(channel, callOptions);
        }
      };
    return ClienteServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void crearCliente(espe.edu.rpc.grpc.ClienteRequest request,
        io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.ClienteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCrearClienteMethod(), responseObserver);
    }

    /**
     */
    default void obtenerCliente(espe.edu.rpc.grpc.ClienteIdRequest request,
        io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.ClienteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getObtenerClienteMethod(), responseObserver);
    }

    /**
     */
    default void listarClientes(espe.edu.rpc.grpc.Empty request,
        io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.ClienteListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListarClientesMethod(), responseObserver);
    }

    /**
     */
    default void actualizarCliente(espe.edu.rpc.grpc.ClienteRequest request,
        io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.BoolResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getActualizarClienteMethod(), responseObserver);
    }

    /**
     */
    default void eliminarCliente(espe.edu.rpc.grpc.ClienteIdRequest request,
        io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.BoolResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEliminarClienteMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ClienteService.
   */
  public static abstract class ClienteServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ClienteServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ClienteService.
   */
  public static final class ClienteServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ClienteServiceStub> {
    private ClienteServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClienteServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClienteServiceStub(channel, callOptions);
    }

    /**
     */
    public void crearCliente(espe.edu.rpc.grpc.ClienteRequest request,
        io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.ClienteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCrearClienteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void obtenerCliente(espe.edu.rpc.grpc.ClienteIdRequest request,
        io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.ClienteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getObtenerClienteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listarClientes(espe.edu.rpc.grpc.Empty request,
        io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.ClienteListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListarClientesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void actualizarCliente(espe.edu.rpc.grpc.ClienteRequest request,
        io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.BoolResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getActualizarClienteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void eliminarCliente(espe.edu.rpc.grpc.ClienteIdRequest request,
        io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.BoolResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEliminarClienteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ClienteService.
   */
  public static final class ClienteServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ClienteServiceBlockingStub> {
    private ClienteServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClienteServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClienteServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public espe.edu.rpc.grpc.ClienteResponse crearCliente(espe.edu.rpc.grpc.ClienteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCrearClienteMethod(), getCallOptions(), request);
    }

    /**
     */
    public espe.edu.rpc.grpc.ClienteResponse obtenerCliente(espe.edu.rpc.grpc.ClienteIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getObtenerClienteMethod(), getCallOptions(), request);
    }

    /**
     */
    public espe.edu.rpc.grpc.ClienteListResponse listarClientes(espe.edu.rpc.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListarClientesMethod(), getCallOptions(), request);
    }

    /**
     */
    public espe.edu.rpc.grpc.BoolResponse actualizarCliente(espe.edu.rpc.grpc.ClienteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getActualizarClienteMethod(), getCallOptions(), request);
    }

    /**
     */
    public espe.edu.rpc.grpc.BoolResponse eliminarCliente(espe.edu.rpc.grpc.ClienteIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEliminarClienteMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ClienteService.
   */
  public static final class ClienteServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ClienteServiceFutureStub> {
    private ClienteServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClienteServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClienteServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<espe.edu.rpc.grpc.ClienteResponse> crearCliente(
        espe.edu.rpc.grpc.ClienteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCrearClienteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<espe.edu.rpc.grpc.ClienteResponse> obtenerCliente(
        espe.edu.rpc.grpc.ClienteIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getObtenerClienteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<espe.edu.rpc.grpc.ClienteListResponse> listarClientes(
        espe.edu.rpc.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListarClientesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<espe.edu.rpc.grpc.BoolResponse> actualizarCliente(
        espe.edu.rpc.grpc.ClienteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getActualizarClienteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<espe.edu.rpc.grpc.BoolResponse> eliminarCliente(
        espe.edu.rpc.grpc.ClienteIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEliminarClienteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREAR_CLIENTE = 0;
  private static final int METHODID_OBTENER_CLIENTE = 1;
  private static final int METHODID_LISTAR_CLIENTES = 2;
  private static final int METHODID_ACTUALIZAR_CLIENTE = 3;
  private static final int METHODID_ELIMINAR_CLIENTE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREAR_CLIENTE:
          serviceImpl.crearCliente((espe.edu.rpc.grpc.ClienteRequest) request,
              (io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.ClienteResponse>) responseObserver);
          break;
        case METHODID_OBTENER_CLIENTE:
          serviceImpl.obtenerCliente((espe.edu.rpc.grpc.ClienteIdRequest) request,
              (io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.ClienteResponse>) responseObserver);
          break;
        case METHODID_LISTAR_CLIENTES:
          serviceImpl.listarClientes((espe.edu.rpc.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.ClienteListResponse>) responseObserver);
          break;
        case METHODID_ACTUALIZAR_CLIENTE:
          serviceImpl.actualizarCliente((espe.edu.rpc.grpc.ClienteRequest) request,
              (io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.BoolResponse>) responseObserver);
          break;
        case METHODID_ELIMINAR_CLIENTE:
          serviceImpl.eliminarCliente((espe.edu.rpc.grpc.ClienteIdRequest) request,
              (io.grpc.stub.StreamObserver<espe.edu.rpc.grpc.BoolResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCrearClienteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              espe.edu.rpc.grpc.ClienteRequest,
              espe.edu.rpc.grpc.ClienteResponse>(
                service, METHODID_CREAR_CLIENTE)))
        .addMethod(
          getObtenerClienteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              espe.edu.rpc.grpc.ClienteIdRequest,
              espe.edu.rpc.grpc.ClienteResponse>(
                service, METHODID_OBTENER_CLIENTE)))
        .addMethod(
          getListarClientesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              espe.edu.rpc.grpc.Empty,
              espe.edu.rpc.grpc.ClienteListResponse>(
                service, METHODID_LISTAR_CLIENTES)))
        .addMethod(
          getActualizarClienteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              espe.edu.rpc.grpc.ClienteRequest,
              espe.edu.rpc.grpc.BoolResponse>(
                service, METHODID_ACTUALIZAR_CLIENTE)))
        .addMethod(
          getEliminarClienteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              espe.edu.rpc.grpc.ClienteIdRequest,
              espe.edu.rpc.grpc.BoolResponse>(
                service, METHODID_ELIMINAR_CLIENTE)))
        .build();
  }

  private static abstract class ClienteServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClienteServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return espe.edu.rpc.grpc.ClienteProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClienteService");
    }
  }

  private static final class ClienteServiceFileDescriptorSupplier
      extends ClienteServiceBaseDescriptorSupplier {
    ClienteServiceFileDescriptorSupplier() {}
  }

  private static final class ClienteServiceMethodDescriptorSupplier
      extends ClienteServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ClienteServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ClienteServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClienteServiceFileDescriptorSupplier())
              .addMethod(getCrearClienteMethod())
              .addMethod(getObtenerClienteMethod())
              .addMethod(getListarClientesMethod())
              .addMethod(getActualizarClienteMethod())
              .addMethod(getEliminarClienteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
