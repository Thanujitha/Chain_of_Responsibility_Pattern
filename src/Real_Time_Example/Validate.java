package Real_Time_Example;

class Request {

    private String parameters;
    private String url;

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParameters() {
        return parameters;
    }

    public String getUrl() {
        return url;
    }

}

abstract class Filter {

    protected Filter filter;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public abstract void filter(Request request);
}

class Filter1 extends Filter {

    @Override
    public void filter(Request request) {
        if (request.getUrl().endsWith(".jsp")) {
            this.filter.filter(request);
        } else {
            System.out.println("Invalid URL");
        }
    }

}

class Filter2 extends Filter {

    @Override
    public void filter(Request request) {
        if (request.getParameters().contains("username=") && request.getParameters().contains("password=")) {
            this.filter.filter(request);
        } else {
            System.out.println("Invalid Parameters");
        }
    }

}

class Filter3 extends Filter {

    @Override
    public void filter(Request request) {
        if (request.getParameters().equals("username=abc&password=123")) {
            System.out.println("Success");
        } else {
            System.out.println("Invalid Username & Password");
        }
    }

}

public class Validate {

    public static void main(String[] args) {
        Request request = new Request();
        request.setUrl("www.abc.com/a.jsp");
        request.setParameters("username=abc&password=123");

        Filter1 filter1 = new Filter1();
        Filter2 filter2 = new Filter2();
        Filter3 filter3 = new Filter3();

        filter1.setFilter(filter2);
        filter2.setFilter(filter3);

        filter1.filter(request);
    }
}
