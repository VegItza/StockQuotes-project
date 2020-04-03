# StockQuotes

## DUE: 7 Apr 2020

## Instructions:

Create an StockQuote Android application using the **Stock.java** provided. Your application should be fully funtional and perform network retrieval for current stock quote for the stock symbol inputted by the user. **Threading** is required for this assignment.  There is one requirements when the phone rotates: **1.** All state of the app should be preserved. If I press 'G' and a 'O' and rotate the phone, I should be able to press 'O' and 'G' to continue 'GOOG'. Likewise, the returned values should also be maintained. Error handling must be implemented when an illegal symbol is typed in (see screenshot). The example screenshot shows what will get you a B+/A-. 

Examples of (but not limited to) WOW factors:
* Any visual WOW elements. Must look professional.
* Slide out drawer that is useful.
* History list to be re-ran with multiple symbols.

### TODO:
1. Open Android Studio and create an Android project named StockQuotes-\<yourLastName\>.
2. Create a README.md and put '\#README' in it.
3. VCS -> Import into Version Control -> Share Project on GitHub. Use 'Initial Commit' as commit message.
4. Verify files were uploaded to your GitHub account.
5. Complete the project.
 
 When you are complete with your project, commit and push files to GitHub. VCS -> Commit Changes
 
 ***Note:*** Any issues you have with either the GitHub steps or Java/Android questions should be asked publically in Slack. If you have a question, chances are someone else does also. If you see someone has posted a question and you know the answer, please chime in and answer.
 
 
Example api call and JSON return:
https://api.iextrading.com/1.0/stock/aapl/book
```
{
  "quote": {
    "symbol": "AAPL",
    "companyName": "Apple Inc.",
    "primaryExchange": "Nasdaq Global Select",
    "sector": "Technology",
    "calculationPrice": "tops",
    "open": 175.15,
    "openTime": 1520260200737,
    "close": 176.21,
    "closeTime": 1520024400193,
    "high": 177.62,
    "low": 174.52,
    "latestPrice": 177.085,
    "latestSource": "IEX real time price",
    "latestTime": "12:49:13 PM",
    "latestUpdate": 1520272153997,
    "latestVolume": 14931766,
    "iexRealtimePrice": 177.085,
    "iexRealtimeSize": 300,
    "iexLastUpdated": 1520272153997,
    "delayedPrice": 177.02,
    "delayedPriceTime": 1520271265875,
    "previousClose": 176.21,
    "change": 0.875,
    "changePercent": 0.00497,
    "iexMarketPercent": 0.03658,
    "iexVolume": 546204,
    "avgTotalVolume": 45610593,
    "iexBidPrice": 176.96,
    "iexBidSize": 400,
    "iexAskPrice": 177.04,
    "iexAskSize": 100,
    "marketCap": 898531592105,
    "peRatio": 19.25,
    "week52High": 180.615,
    "week52Low": 137.05,
    "ytdChange": 0.022930453964936825
  },
  "bids": [
    {
      "price": 176.96,
      "size": 400,
      "timestamp": 1520272161472
    },
    {
      "price": 172.78,
      "size": 100,
      "timestamp": 1520260206051
    },
    {
      "price": 172.67,
      "size": 100,
      "timestamp": 1520272151128
    },
    {
      "price": 172.37,
      "size": 100,
      "timestamp": 1520260203492
    },
    {
      "price": 170.68,
      "size": 120,
      "timestamp": 1520265355813
    },
    {
      "price": 169.34,
      "size": 100,
      "timestamp": 1520260206188
    },
    {
      "price": 168.01,
      "size": 100,
      "timestamp": 1520260206070
    },
    {
      "price": 161.11,
      "size": 100,
      "timestamp": 1520261100039
    }
  ],
  "asks": [
    {
      "price": 177.05,
      "size": 100,
      "timestamp": 1520272161726
    },
    {
      "price": 178.5,
      "size": 100,
      "timestamp": 1520260204089
    },
    {
      "price": 178.8,
      "size": 400,
      "timestamp": 1520260201663
    },
    {
      "price": 179.64,
      "size": 100,
      "timestamp": 1520260206212
    },
    {
      "price": 180.33,
      "size": 100,
      "timestamp": 1520260203489
    },
    {
      "price": 181,
      "size": 141,
      "timestamp": 1520266952294
    },
    {
      "price": 181.52,
      "size": 100,
      "timestamp": 1520272151128
    },
    {
      "price": 190.92,
      "size": 100,
      "timestamp": 1520267121975
    },
    {
      "price": 198.8,
      "size": 100,
      "timestamp": 1520268766323
    }
  ],
  "trades": [
    {
      "price": 177.085,
      "size": 300,
      "tradeId": 543976636,
      "isISO": false,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272153997
    },
    {
      "price": 177.07,
      "size": 75,
      "tradeId": 543942008,
      "isISO": false,
      "isOddLot": true,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272152435
    },
    {
      "price": 177.11,
      "size": 100,
      "tradeId": 543574341,
      "isISO": true,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272136305
    },
    {
      "price": 177.11,
      "size": 100,
      "tradeId": 543579916,
      "isISO": true,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272136609
    },
    {
      "price": 177.11,
      "size": 100,
      "tradeId": 543055507,
      "isISO": false,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272111068
    },
    {
      "price": 177.13,
      "size": 100,
      "tradeId": 543011534,
      "isISO": true,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272109269
    },
    {
      "price": 177.13,
      "size": 100,
      "tradeId": 543011658,
      "isISO": true,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272109270
    },
    {
      "price": 177.16,
      "size": 100,
      "tradeId": 541941314,
      "isISO": true,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272071183
    },
    {
      "price": 177.15,
      "size": 100,
      "tradeId": 541944167,
      "isISO": true,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272071205
    },
    {
      "price": 177.14,
      "size": 100,
      "tradeId": 541857526,
      "isISO": false,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272066114
    },
    {
      "price": 177.125,
      "size": 100,
      "tradeId": 541834654,
      "isISO": false,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272064936
    },
    {
      "price": 177.13,
      "size": 200,
      "tradeId": 541539076,
      "isISO": false,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272051219
    },
    {
      "price": 177.13,
      "size": 100,
      "tradeId": 541539084,
      "isISO": false,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272051219
    },
    {
      "price": 177.13,
      "size": 100,
      "tradeId": 541539200,
      "isISO": false,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272051222
    },
    {
      "price": 177.105,
      "size": 100,
      "tradeId": 541492663,
      "isISO": false,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272050040
    },
    {
      "price": 177.145,
      "size": 200,
      "tradeId": 540780205,
      "isISO": false,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272020032
    },
    {
      "price": 177.15,
      "size": 100,
      "tradeId": 540787704,
      "isISO": true,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272020120
    },
    {
      "price": 177.16,
      "size": 100,
      "tradeId": 540806269,
      "isISO": true,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272020786
    },
    {
      "price": 177.14,
      "size": 100,
      "tradeId": 540672314,
      "isISO": true,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272015409
    },
    {
      "price": 177.125,
      "size": 200,
      "tradeId": 540599011,
      "isISO": false,
      "isOddLot": false,
      "isOutsideRegularHours": false,
      "isSinglePriceCross": false,
      "isTradeThroughExempt": false,
      "timestamp": 1520272011654
    }
  ],
  "systemEvent": {
    "systemEvent": "R",
    "timestamp": 1520260200000
  }
}
```
