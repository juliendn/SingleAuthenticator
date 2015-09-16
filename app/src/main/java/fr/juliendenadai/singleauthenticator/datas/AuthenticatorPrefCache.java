package fr.juliendenadai.singleauthenticator.datas;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

import javax.inject.Inject;
import javax.inject.Singleton;

import fr.juliendenadai.singleauthenticator.models.Configuration;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by julien on 16/09/15.
 */
@Singleton
public class AuthenticatorPrefCache implements AuthenticatorCache {

    private static final String AUTHENTICATOR_PREFS_NAME = "authenticators";

    private static final String AUTHENTICATOR_PREFS_KEY = "authenticators_gson";

    private static final String EMPTY = "{" +
            "\"authenticators\":[" +
            "{" +
            "\"issuer_int\":\"test\"," +
            "\"issuer_ext\":\"test\"," +
            "\"issuer_alt\":\"test\"," +
            "\"label\":\"test\"," +
            "\"label_alt\":\"test\"," +
            "\"image\":\"test\"," +
            "\"image_alt\":\"test\"," +
            "\"type\":\"totp\"," +
            "\"algo\":\"sha1\"," +
            "\"secret\":\"abcdefghijkfmnopqrstuvwxyz\"," +
            "\"digits\":6," +
            "\"counter\":-1," +
            "\"period\":-1" +
            "}," +
            "{" +
            "\"issuer_int\":\"test2\"," +
            "\"issuer_ext\":\"test2\"," +
            "\"issuer_alt\":\"test2\"," +
            "\"label\":\"test2\"," +
            "\"label_alt\":\"test2\"," +
            "\"image\":\"test2\"," +
            "\"image_alt\":\"test2\"," +
            "\"type\":\"hotp\"," +
            "\"algo\":\"sha256\"," +
            "\"secret\":\"abcdefghijkfmnopqrstuvwxyz\"," +
            "\"digits\":8," +
            "\"counter\":-1," +
            "\"period\":-1" +
            "}" +
            "]," +
            "\"last_used\":-1" +
            "}";
    private static final int PREFS_MODE = Context.MODE_PRIVATE;
    private final SharedPreferences mPrefs;
    private Gson mGson;


    @Inject
    public AuthenticatorPrefCache(Context context) {
        mPrefs = context.getSharedPreferences(AUTHENTICATOR_PREFS_NAME, PREFS_MODE);
        mGson = new GsonBuilder().registerTypeHierarchyAdapter(byte[].class,
                new ByteArrayToBase64TypeAdapter()).create();
    }

    @Override
    public Observable<Configuration> getAllAuthenticators() {
        return Observable.create(new Observable.OnSubscribe<Configuration>() {
            @Override
            public void call(Subscriber<? super Configuration> subscriber) {
                try {
                    final String json = mPrefs.getString(AUTHENTICATOR_PREFS_KEY, EMPTY);
                    final Configuration configuration = mGson.fromJson(json, Configuration.class);
                    subscriber.onNext(configuration);
                    subscriber.onCompleted();
                } catch (JsonSyntaxException jse) {
                    subscriber.onError(jse);
                }
            }
        });
    }

    // Using Android's base64 libraries. This can be replaced with any base64 library.
    private static class ByteArrayToBase64TypeAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
        public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Base64.decode(json.getAsString(), Base64.NO_WRAP);
        }

        public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(Base64.encodeToString(src, Base64.NO_WRAP));
        }
    }
}
