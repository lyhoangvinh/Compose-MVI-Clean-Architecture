-if class com.base.data.remote.dto.BaseResponse
-keepnames class com.base.data.remote.dto.BaseResponse
-if class com.base.data.remote.dto.BaseResponse
-keep class com.base.data.remote.dto.BaseResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi,java.lang.reflect.Type[]);
}
-if class com.base.data.remote.dto.BaseResponse
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.base.data.remote.dto.BaseResponse
-keepclassmembers class com.base.data.remote.dto.BaseResponse {
    public synthetic <init>(java.lang.String,java.lang.String,java.lang.Object,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
