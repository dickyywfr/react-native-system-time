
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNSystemTimeSpec.h"

@interface SystemTime : NSObject <NativeSystemTimeSpec>
#else
#import <React/RCTBridgeModule.h>

@interface SystemTime : NSObject <RCTBridgeModule>
#endif

@end
