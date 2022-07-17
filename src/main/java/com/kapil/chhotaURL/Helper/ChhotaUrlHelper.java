package com.kapil.chhotaURL.Helper;

import com.kapil.chhotaURL.Repository.IChhotaUrlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Component
@Slf4j
public class ChhotaUrlHelper {

    @Autowired
    private IChhotaUrlRepository chhotaUrlRepository;

    @Value("${server.port:}")
    private String port;

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    private static final int SHORT_URL_CHAR_SIZE = 7;

    public String generateChhotaUrlHashCode(String longURL) {
        while (true) {
            String hash = ChhotaUrlHelper.convert(longURL);
            int numberOfCharsInHash = hash.length();
            int counter = 0;
            while (counter < numberOfCharsInHash - SHORT_URL_CHAR_SIZE) {
                if (!isExistsURLHashCode(hash.substring(counter, counter + SHORT_URL_CHAR_SIZE))) {
                    return hash.substring(counter, counter + SHORT_URL_CHAR_SIZE);
                }
                counter++;
            }
        }
    }

    public static String convert(String longURL) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(longURL.getBytes());
            byte[] messageDigest = digest.digest();
            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(Integer.toHexString(0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isExistsURLHashCode(String hashCode) {
        log.debug("Check hashCode : {}, is already present or not", hashCode);
        boolean isPresent = chhotaUrlRepository.existsByHashCode(hashCode);
        log.debug("hashCode is present : {}", isPresent);
        return isPresent;
    }

    public String createChhotaUrl(String hashCode) {
        String chhotaUrl = "https://chhota-url.herokuapp.com/chhotaUrl/url/" + hashCode;
        log.debug("Crated chhota url -> hashCode : {}, chhotaUrl : {}", hashCode, chhotaUrl);
        return chhotaUrl;
    }
}
