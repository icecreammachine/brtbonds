package com.icecreammachine.brtbonds.network;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Crunchify.com
 *         <p>
 *         In Java How to Download file from any given URL?
 *         <p>
 *         5 different ways: 1. File Download using apache commons-io. Just line
 *         of code 2. File Download using Stream Operation 3. File Download
 *         using NIO Operation 4. File Download using Files.copy() 5. File
 *         Download using Apache HttpComponents()
 */
public class CrunchifyDownloadFileFromURL {

    private static final Logger logger = LoggerFactory.getLogger(
        CrunchifyDownloadFileFromURL.class
    );

    public static void downloadFile(String fileURL, String saveDir)
        throws Exception {
        try {
            doTrustToCertificates();
            // Method-1: File Download using apache commons-io. Just line of code.
            // crunchifyFileDownloadUsingApacheCommonsIO(fileURL, saveDir);

            // Method-2: File Download using Stream Operation
            crunchifyFileDownloadUsingStream(fileURL, saveDir);
            // Method-3: File Download using NIO Operation
            // crunchifyFileDownloadUsingNIO(fileURL, saveDir);

            // Method-4: File Download using Files.copy()
            // crunchifyFileDownloadUsingFilesCopy(fileURL, saveDir);

            // Method-5: File Download using Apache HttpComponents()
            // crunchifyFileDownloadUsingHttpComponents(fileURL, saveDir);

        } catch (IOException crunchifyException) {
            crunchifyException.printStackTrace();
        }
    }

    // Method-1: Using apache commons-io. Just single line of code.
    // FileUtils.copyURLToFile(URL, File);
    //    private static void crunchifyFileDownloadUsingApacheCommonsIO(String crunchifyURL, String crunchifyFileLocalPath) {
    //        URL crunchifyRobotsURL = null;
    //        try {
    //            crunchifyRobotsURL = new URL(crunchifyURL);
    //            FileUtils.copyURLToFile(crunchifyRobotsURL, new File(crunchifyFileLocalPath));
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //
    //        printResult("File Downloaded Successfully with apache commons-io Operation \n");
    //
    //    }

    // Method-2: File Download using Stream Operation
    private static void crunchifyFileDownloadUsingStream(
        String crunchifyURL,
        String crunchifyFileLocalPath
    ) throws IOException {
        URL crunchifyRobotsURL = new URL(crunchifyURL);

        // BufferedInputStream(): Creates a BufferedInputStream and saves its argument,
        // the input stream in, for later use. An internal buffer array is created and
        // stored in buf.
        BufferedInputStream crunchifyInputStream = new BufferedInputStream(
            crunchifyRobotsURL.openStream()
        );
        FileOutputStream crunchifyOutputStream = new FileOutputStream(
            crunchifyFileLocalPath
        );

        byte[] crunchifySpace = new byte[2048];
        int crunchifyCounter = 0;

        while (
            (crunchifyCounter = crunchifyInputStream.read(
                    crunchifySpace,
                    0,
                    1024
                )) !=
            -1
        ) {
            crunchifyOutputStream.write(crunchifySpace, 0, crunchifyCounter);
        }

        crunchifyOutputStream.close();
        crunchifyInputStream.close();

        printResult(
            "File " +
            crunchifyFileLocalPath +
            " Downloaded Successfully with Java Stream Operation \n"
        );
    }

    // Method-3: File Download using NIO Operation
    //    private static void crunchifyFileDownloadUsingNIO(String crunchifyURL, String crunchifyFileLocalPath) throws IOException {
    //        URL crunchifyRobotsURL = new URL(crunchifyURL);
    //
    //        // ReadableByteChannel(): A channel that can read bytes. Only one read operation upon a readable channel may be in progress at any given time. If one thread initiates a read operation upon a channel then any other thread that attempts to initiate another read operation will block until the first operation is complete.
    //        // Whether or not other kinds of I/O operations may proceed concurrently with a read operation depends upon the type of the channel.
    //
    //        // openStream(): Opens a connection to this URL and returns an InputStream for reading from that connection.
    //        ReadableByteChannel crunchifyByteChannel = Channels.newChannel(crunchifyRobotsURL.openStream());
    //
    //        // FileOutputStream(): A file output stream is an output stream for writing data to a File or to a FileDescriptor. Whether or not a file is available or may be created depends upon the underlying platform. Some platforms, in particular, allow a file to be opened for writing by only one FileOutputStream (or other file-writing object) at a time.
    //        // In such situations the constructors in this class will fail if the file involved is already open.
    //        FileOutputStream crunchifyOutputStream = new FileOutputStream(crunchifyFileLocalPath);
    //
    //        // getChannel(): Returns the unique FileChannel object associated with this file output stream.
    //        // transferFrom(): Transfers bytes into this channel's file from the given readable byte channel.
    //        // An attempt is made to read up to count bytes from the source channel and write them to this channel's file starting at the given position. An invocation of this method may or may not transfer all of the requested bytes; whether or not it does so depends upon the natures and states of the channels.
    //        // Fewer than the requested number of bytes will be transferred if the source channel has fewer than count bytes remaining, or if the source channel is non-blocking and has fewer than count bytes immediately available in its input buffer.
    //
    //        crunchifyOutputStream.getChannel().transferFrom(crunchifyByteChannel, 0, Long.MAX_VALUE);
    //        // A constant holding the maximum value a long can have.
    //
    //        // Closes this file output stream and releases any system resources associated with this stream. This file output stream may no longer be used for writing bytes.
    //        crunchifyOutputStream.close();
    //
    //        // Closes this channel. After a channel is closed, any further attempt to invoke I/O operations upon it will cause a ClosedChannelException to be thrown.
    //        crunchifyByteChannel.close();
    //
    //        printResult("File Downloaded Successfully with Java NIO ReadableByteChannel Operation \n");
    //
    //    }

    // Method-4: File Download using Files.copy()
    //    private static void crunchifyFileDownloadUsingFilesCopy(String crunchifyURL, String crunchifyFileLocalPath) {
    //
    //        // URI Creates a URI by parsing the given string.
    //        // This convenience factory method works as if by invoking the URI(String) constructor;
    //        // any URISyntaxException thrown by the constructor is caught and wrapped in a new IllegalArgumentException object, which is then thrown.
    //        try (InputStream crunchifyInputStream = URI.create(crunchifyURL).toURL().openStream()) {
    //
    //            // Files: This class consists exclusively of static methods that operate on files, directories, or other types of files.
    //            // copy() Copies all bytes from an input stream to a file. On return, the input stream will be at end of stream.
    //
    //            // Paths: This class consists exclusively of static methods that return a Path by converting a path string or URI.
    //            // Paths.get() Converts a path string, or a sequence of strings that when joined form a path string, to a Path.
    //            Files.copy(crunchifyInputStream, Paths.get(crunchifyFileLocalPath), StandardCopyOption.REPLACE_EXISTING);
    //        } catch (IOException e) {
    //            // printStackTrace: Prints this throwable and its backtrace to the standard error stream.
    //            e.printStackTrace();
    //        }
    //
    //        printResult("File Downloaded Successfully with Files.copy() Operation \n");
    //    }

    // Method-5: File Download using Apache HttpComponents()
    //    private static void crunchifyFileDownloadUsingHttpComponents(String crunchifyURL, String crunchifyFileLocalPath) {
    //        CloseableHttpClient crunchifyHTTPClient = HttpClients.createDefault();
    //
    //        HttpGet crunchifyHTTPGet = new HttpGet(crunchifyURL);
    //
    //        CloseableHttpResponse crunchifyHTTPResponse = null;
    //        try {
    //            crunchifyHTTPResponse = crunchifyHTTPClient.execute(crunchifyHTTPGet);
    //            HttpEntity crunchifyHttpEntity = crunchifyHTTPResponse.getEntity();
    //
    //            if (crunchifyHttpEntity != null) {
    //                FileUtils.copyInputStreamToFile(crunchifyHttpEntity.getContent(), new File(crunchifyFileLocalPath));
    //            }
    //        } catch (IOException e) {
    //            // IOException: Signals that an I/O exception of some sort has occurred.
    //            // This class is the general class of exceptions produced by failed or interrupted I/O operations.
    //            e.printStackTrace();
    //        }
    //
    //        printResult("File Downloaded Successfully with Apache HttpComponents() Operation \n");
    //    }

    // Simple Crunchify Print Utility
    private static void printResult(String crunchifyResult) {
        logger.info(crunchifyResult);
    }

    private static void doTrustToCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[] {
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkServerTrusted(
                    X509Certificate[] certs,
                    String authType
                ) throws CertificateException {
                    return;
                }

                public void checkClientTrusted(
                    X509Certificate[] certs,
                    String authType
                ) throws CertificateException {
                    return;
                }
            },
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println(
                        "Warning: URL host '" +
                        urlHostName +
                        "' is different to SSLSession host '" +
                        session.getPeerHost() +
                        "'."
                    );
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }
}
