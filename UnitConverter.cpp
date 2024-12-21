#include <string>

extern "C" __declspec(dllexport) double convert(const char* from, const char* to, double value) {
    if (std::string(from) == "meters" && std::string(to) == "kilometers") {
        return value / 1000.0;
    }
    return value;
}
