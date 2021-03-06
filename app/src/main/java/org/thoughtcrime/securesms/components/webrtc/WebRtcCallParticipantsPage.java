package org.thoughtcrime.securesms.components.webrtc;

import androidx.annotation.NonNull;

import org.thoughtcrime.securesms.events.CallParticipant;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

class WebRtcCallParticipantsPage {

  private final List<CallParticipant> callParticipants;
  private final boolean               isSpeaker;
  private final boolean               isRenderInPip;
  
  static WebRtcCallParticipantsPage forMultipleParticipants(@NonNull List<CallParticipant> callParticipants,
                                                            boolean isRenderInPip) 
  {
    return new WebRtcCallParticipantsPage(callParticipants, false, isRenderInPip);
  }
  
  static WebRtcCallParticipantsPage forSingleParticipant(@NonNull CallParticipant singleParticipant,
                                                         boolean isRenderInPip)
  {
    return new WebRtcCallParticipantsPage(Collections.singletonList(singleParticipant), true, isRenderInPip);
  }

  private WebRtcCallParticipantsPage(@NonNull List<CallParticipant> callParticipants,
                                     boolean isSpeaker,
                                     boolean isRenderInPip) 
  {
    this.callParticipants = callParticipants;
    this.isSpeaker        = isSpeaker;
    this.isRenderInPip    = isRenderInPip;
  }

  public @NonNull List<CallParticipant> getCallParticipants() {
    return callParticipants;
  }

  public boolean isRenderInPip() {
    return isRenderInPip;
  }

  public boolean isSpeaker() {
    return isSpeaker;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WebRtcCallParticipantsPage that = (WebRtcCallParticipantsPage) o;
    return isSpeaker == that.isSpeaker &&
        isRenderInPip == that.isRenderInPip &&
        callParticipants.equals(that.callParticipants);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callParticipants, isSpeaker);
  }
}
